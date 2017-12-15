#Prerequisites for HowTo:
 
##Configure a Cassandra multi-node Cluster deployed in Azure Cloud Platform Architecture:
- Cassandra Multi-Node Cluster, Single Datacenter, Replication Factor 1.  
- Deployed in Azure environment with virtual machine type DS12_V2 Standard:
- Cassandra version: 3.11 Community Edition
- Heap Memory allocated: 6.75GB on each node
- Account Micro Service Image Tags: 1.0-392
- OS: Oracle Linux version 7.3
- CPU Cores: 4, 2.40GHz
- RAM Memory: 28GB
- MAX IOPS: 12800
- Local Disk Size: Mounted Linux OS Resources: 55G
- Local Disk size: Mounted Cassandra Data files of 100GB. 4 Data Disks of 25GB on RAID-0 Configured on each node.

##Start your machine and install the following software:

1. ntp (Packages are normally ntp, ntpdata and ntp-doc)
1. wget (Unless you have your packages copied over via other means)
1. vim (Or your favorite text editor)

##Retrieve the following packages

1. Java 8
1. Apache Cassandra DSE or Community Edition (Latest Stable Version)
1. Java JNA


#Installation Processes:

##Set up NTP
This can be more or less dependent of your system, but the following commands should do it. 
You can check this guide also: https://www.tecmint.com/install-ntp-server-in-centos/

	#chkconfig ntpd on
	#ntpdate pool.ntp.org
	#service ntpd start

##Set up Java (Let’s assume will be installed in /opt)
###Extract Java and install it:
 
	#tar xzf [java_file].tar.gz
	#update-alternatives --install /usr/bin/java java /opt/java/bin/java 1

###Verify that Java was correctly installed:

	#java -version
1. java version "1.8.0_131"
1. Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
1. Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)

###Let’s put JNA into place

	#mv jna-VERSION.jar /opt/java/lib

##Set up Cassandra (Let’s assume will be installed In /opt)

###Extract Cassandra:

	#tar xzf [cassandra_file].tar.gz

###Create Cassandra Directories:

	#mkdir /var/lib/cassandra
	#mkdir /var/lib/cassandra/commitlog
	#mkdir /var/lib/cassandra/data
	#mkdir /var/lib/cassandra/saved_caches
	#mkdir /var/log/cassandra

##Linux and Cassandra Parameters Configurations:

###Linux Kernel Configuration files

	#vim /etc/security/limits.conf

###Add the following:

- root soft memlock unlimited
- root hard memlock unlimited
- root – nofile 100000
- root – nproc 32768
- root – as unlimited

###Cassandra Configuration files
	#vi /etc/security/limits.d/cassandra.conf
- cassandra memlock unlimited
- cassandra nofile 100000

###Set the parameter in the following in file

	#vi /etc/security/limits.d/90-nproc.conf:
- * – nproc 32768

###Add the following to the sysctl file:

	#vim /etc/sysctl.conf
	#vm.max_map_count = 1048575

###Finally Reboot the machine or perform the below command:

	#sysctl -p

##Verify the Firewall following ports must be open:

###Inter node Ports
- 7000    Cassandra inter-node cluster communication.
- 7001    Cassandra SSL inter-node cluster communication.
- 7199    Cassandra JMX monitoring port.

###Client Ports
- 9042    Cassandra client port (Native).
- 9160    Cassandra client port (Thrift).

Note: Some/Most guides tell you to disable swap, I think of swap as an acrobat’s safety net, it should never have to be put to use, but in need it exists. As such, I never disable it and I put a low swappiness (around 10). You can read more about it here and here.

 Cassandra Configuration
Note: Cassandra has a lot of settings, these are the ones you should always set if you are going live. Lots of them depend on hardware and/or workload. In the meantime, you can read about them here.

	#vim /opt/cassandra/conf/cassandra.yaml

##Edit the following fields in the /etc/cassandra/cassandra.yaml:

- cluster_name: "Whatever you would like to call it"
- data_file_directories: /var/lib/cassandra/data
- commitlog_directory: /var/lib/cassandra/commitlog
- saved_caches_directory: /var/lib/cassandra/saved_caches
- commitlog_total_space_in_mb: 8192
- cdc_total_space_in_mb : 4096
- memtable_flush_writers: 2

###Assuming this is your first node, this should be reachable by other nodes
- seeds: "IP"

###This is where you listen for intra node communication
- listen_address: "IP"

###This is where you listen to incoming client connections
- rpc_address: "IP"
- endpoint_snitch: GossipingPropertyFileSnitch

###Edit the snitch property file:

	#vim  /opt/cassandra/conf/cassandra-rackdc.properties:

###Add the DC and the RACK the server is in. Ex:

- dc=DC1
- rack=RAC1

##Cassandra cluster RAID-0 Configuration:

###Step-1: Install the mdadm utility.

	#sudo yum install mdadm

###Step-2: Create the disk partitions.

	#sudo fdisk /dev/sdc
	#sudo fdisk /dev/sdd
	#sudo fdisk /dev/sde
	#sudo fdisk /dev/sdf

###Step-3: Create the RAID-0 Array

 The following example will "stripe" (RAID level 0) three partitions located on three separate data disks (sdc1, sdd1, sde1 and sdf1).

 After running this command a new RAID device called /dev/md127 is created. Also, note that if these data disks we previously part of another defunct RAID array it may be necessary to add the --force parameter to the mdadm command:

    #sudo mdadm --create /dev/md127 --level 0 --raid-devices 4 /dev/sdc1 /dev/sdd1 /dev/sde1 /dev/sdf1

####Output:
1. mdadm: /dev/sdc1 appears to contain an ext2fs file system
1.        size=25164800K  mtime=Tue Nov 28 13:15:12 2017
1. mdadm: /dev/sdd1 appears to contain an ext2fs file system
1.        size=26213376K  mtime=Wed Nov 29 12:35:02 2017
1. mdadm: /dev/sde1 appears to contain an ext2fs file system
1.        size=26213376K  mtime=Wed Nov 29 12:35:14 2017
1. mdadm: /dev/sdf1 appears to contain an ext2fs file system
1.        size=26213376K  mtime=Wed Nov 29 12:35:24 2017
1. Continue creating array? Y 
1. mdadm: Defaulting to version 1.2 metadata
1. mdadm: array /dev/md127 started.


###Step-4: Create the file system on the new RAID device

    #sudo mkfs -t ext4 /dev/md127

###Step-5: Add the new file system to /etc/fstab

    #dmesg | grep SCSI
    #blkid
    #vi /etc/fstab

###Add to the fstab file the below entries on each node:

    Node-1: /dev/md127: UUID="e8804613-0a0c-4736-ab9e-99838037c220" TYPE="ext4"
    Node-2: /dev/md127: UUID="c01a667b-93fd-4da9-8b44-636474a56096" TYPE="ext4"
    Node-3: /dev/md127: UUID="3dbfa6c7-3c89-4568-b22b-5601620d0555" TYPE="ext4"

    Node-1: UUID=e8804613-0a0c-4736-ab9e-99838037c220  /ca-data0  ext4  defaults  0  2
    Node-2: UUID=c01a667b-93fd-4da9-8b44-636474a56096  /ca-data1  ext4  defaults  0  2
    Node-3: UUID=3dbfa6c7-3c89-4568-b22b-5601620d0555  /ca-data2  ext4  defaults  0  2

    Then, save and close /etc/fstab.


Step-6: Test that the /etc/fstab entry is correct:

    #mkdir /ca-data0
    #chmod 755 /ca-data0
    #chown cassandra:cassandra /ca-data0
    #sudo mount -a

####Output:

	#df -h

1. Filesystem      Size  Used Avail Use% Mounted on
1. devtmpfs         14G     0   14G   0% /dev
1. tmpfs            14G     0   14G   0% /dev/shm
1. tmpfs            14G   65M   14G   1% /run
1. tmpfs            14G     0   14G   0% /sys/fs/cgroup
1. /dev/sda2        30G  3.3G   25G  12% /
1. /dev/sda1       497M  176M  321M  36% /boot
1. /dev/sdb1        55G   53M   53G   1% /mnt/resource
1. tmpfs           2.8G     0  2.8G   0% /run/user/1000
1. /dev/md127       98G   61M   93G   1% /ca-data2

###Finally make sure your logs go to /var/log/cassandra:

	#vim /opt/cassandra/conf/logback.xml

##Testing

###Start Cassandra Service

	#service cassandra start or systemctl restart cassandra


###You should see no error here, wait a bit then:

	#grep  JNA /var/log/cassandra/system.log
- INFO  HH:MM:SS JNA mlockall successful

###Then check the status of the ring:

	#nodetool status
#####Datacenter: datacenter1
=======================

1. Status=Up/Down
1. |/ State=Normal/Leaving/Joining/Moving
1. --  Address       Load       Tokens       Owns (effective)  Host ID                               Rack
1. UN  153.78.22.26  4.42 GiB   256          34.2%             742a3cee-914b-4dc9-954e-6808a74a556c  rack1
1. UN  153.78.22.24  4.37 GiB   256          33.8%             2ae52267-245c-48e2-8e33-b38d83c95b58  rack1
1. UN  153.78.22.25  4.15 GiB   256          32.0%             82cb8954-e038-4cc3-9d29-e1813f226e11  rack1

###Creating a keyspace a table and inserting some data:

	#cqlsh 153.78.22.24
	#cqlshCREATE KEYSPACE cashdbox WITH REPLICATION = { 'class' : 'NetworkTopologyStrategy', DC1 : 1};

###Should give no errors

	#cqlshUSE cashbox;
	#cqlsh:sandbox CREATE TABLE data (id uuid, data text, PRIMARY KEY (id));
	#cqlsh:sandbox INSERT INTO data (id, data) values-
	#(c37d661d-7e61-49ea-96a5-68c34e83db3a, 'testing');
	#cqlsh:sandbox SELECT * FROM data;
1. id                                   | data
1. --------------------------------------+---------
1. c37d661d-7e61-49ea-96a5-68c34e83db3a | testing

1. (1 rows)

##In the Kubernates cluster set up the Micro service Heap Memory and contact point in the yaml file:
env:

        - name: JAVA_OPTS
          value: "-Xmx500m -Xms250m"
        - name: DATASTAX_CASSANDRA_CONTACT_POINTS
          value: "153.78.22.24"


##For optimal and Scalable memory allocation install the jemalloc package on each Cassandra node

###Download the latest epel-release rpm from
- http://dl.fedoraproject.org/pub/epel/6/x86_64/

###Install epel-release rpm:
	#rpm -Uvh epel-release*rpm

###Install jemalloc rpm package:
	#yum install jemalloc


###Files:
1. /usr/bin/jemalloc.sh
1. /usr/lib64/libjemalloc.so.1
1. /usr/share/doc/jemalloc-3.6.0/COPYING
1. /usr/share/doc/jemalloc-3.6.0/README
1. /usr/share/doc/jemalloc-3.6.0/VERSION
1. /usr/share/doc/jemalloc-3.6.0/jemalloc.html

##To monitor the Cluster set up the JVM Remote Connection to Cassandra Cluster:
Keep in mind that Larger heaps set up in the Micro Services are better for write intensive workloads, and smaller heaps better for read intensive workloads. 

My suggestion is that we use 4GB and not run the tests on smaller VMs.

###Step-1 modify parameters in the /etc/cassandra/conf/cassandra-env.sh

- "LOCAL_JMX=yes" to "LOCAL_JMX=no" 
- JVM_OPTS=”$JVM_OPTS -Dcom.sun.management.jmxremote.ssl=false”
- JVM_OPTS=”$JVM_OPTS -Dcom.sun.management.jmxremote.authenticate=false”
- JVM_OPTS=”$JVM_OPTS -Djava.rmi.server.hostname=153.78.22.24"
- JVM_OPTS=”$JVM_OPTS -Djava.rmi.server.hostname=153.78.22.25"
- JVM_OPTS="$JVM_OPTS -Djava.rmi.server.hostname=153.78.22.26"

###Step-2: Stop and restart Cassandra Service
	#service cassandra stop  or systemctl restart cassandra
	#service cassandra start  or systemctl restart cassandra

###Step-3: Launch the Jconsole application from the Window Desktop machine and enter the below link.
- service:jmx:rmi:///jndi/rmi://:7199/jmxrmi

###example: 
- service:jmx:rmi:///jndi/rmi://153.78.22.24:7199/jmxrmi
- service:jmx:rmi:///jndi/rmi://153.78.22.25:7199/jmxrmi
- service:jmx:rmi:///jndi/rmi://153.78.22.26:7199/jmxrmi

No user and password is needed.

###And we are done, you can start using your Cassandra multi-node cluster!!!