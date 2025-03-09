#!/bin/bash

set -e

# Get hostname from environment variable
HOSTNAME=`env hostname`
echo "Starting RabbitMQ Server For host: " $HOSTNAME

if [ -z "$CLUSTER_HOST" ]; then
    # Start RabbitMQ server
    /usr/local/bin/docker-entrypoint.sh rabbitmq-server &

    # Wait for RabbitMQ server to start
    sleep 5
    rabbitmqctl wait /var/lib/rabbitmq/mnesia/rabbit\@$HOSTNAME.pid

    # Create a direct exchange
    rabbitmqadmin declare exchange name=direct_exchange type=direct durable=true

    # Create a durable, eagerly synchronized mirrored queue
    rabbitmqadmin declare queue name=mirrored_queue durable=true arguments='{"x-queue-type":"classic", "x-ha-policy":"all", "x-ha-sync-mode":"automatic"}'

    # Bind the queue to the exchange with a routing key
    rabbitmqadmin declare binding source="direct_exchange" destination="mirrored_queue" destination_type="queue" routing_key="routing_key"

    # Set policy for mirrored queue
    rabbitmqctl set_policy ha-all "^mirrored_queue$" '{"ha-mode":"all", "ha-sync-mode":"automatic"}'
else
    # Start RabbitMQ server (in detached mode)
    /usr/local/bin/docker-entrypoint.sh rabbitmq-server -detached

    # Wait for RabbitMQ server to start
    sleep 5
    rabbitmqctl wait /var/lib/rabbitmq/mnesia/rabbit\@$HOSTNAME.pid

    # Join the cluster
    rabbitmqctl stop_app
    rabbitmqctl join_cluster rabbit@$CLUSTER_HOST
    rabbitmqctl start_app
fi

# Keep foreground process active ...
tail -f /dev/null