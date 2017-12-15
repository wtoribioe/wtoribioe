USE system;
SELECT * FROM schema_keyspaces;
SELECT * FROM system_schema.keyspaces; 
DESCRIBE keyspaces;
DESCRIBE TABLES;
HELP DESCRIBE;

cqlsh > ALTER KEYSPACE keyspace1 WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

nodetool status
nodetool info
nodetool tpstats
nodetool netstats  

Per KeySpaces:
--------------
nodetool cfstats txacct
nodetool cfstats txcashbox
nodetool cfstats txfintrans

Per Tables: Tables on Keyspace : txacct
----------------------------------------
nodetool cfhistograms txacct account
nodetool cfhistograms txacct accountentry
nodetool cfhistograms txacct accountnum_account
nodetool cfhistograms txacct bank_rt_accountnum_account
nodetool cfhistograms txacct banknum_accountnum_account
nodetool cfhistograms txacct rtnum_accountnum_account
nodetool cfhistograms txacct subledger

--------------------------------
What to look at Monitoring data:
--------------------------------
Heap size and usage
Garba Collections
I/O Wait

RowMutationStage(Writes)
  -Active and Pending
  
CompactionsStage
Compaction Count
Cache Hit Rate

ReadStage
 -Active and Pending 
 
 
 Try out the Cassandra Load Test Tool that is found under the C* installation directory under tools as: 
 /tool/bin/cassandra-stress

 
-----------------------------------
How to get into a Docker Container:
-----------------------------------
a) Look where the container is running on which node in the cluster
b) Then perform the command #docker ps | grep cassandra
Output:
-------
9089fbfc55b6        docker-registry:5000/cassandra@sha256:195850db36326f88e1de5500188c225d84f6e7eb3a19180f601e773994ef1a03                                       
dc03346dfd49        gcr.io/google_containers/pause-amd64:3.0    
c) Finally perform the command   docker exec -it 9089f /bin/bash   
output:
--------
root@cassandra-db-2926804656-trkxm:/#
Now you are into the docker container      