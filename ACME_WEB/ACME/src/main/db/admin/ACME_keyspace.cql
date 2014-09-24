CREATE KEYSPACE acme_space
    WITH REPLICATION = { 'class': 'SimpleStrategy', 'replication_factor': '1' };