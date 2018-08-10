# IPFS(InterPlanetary File System)

### Installation
*Download the file from [https://dist.ipfs.io](https://dist.ipfs.io/#go-ipfs). The IPFS is implemented by Go language.*

##### Unzip The IPFS

Unzip the file of downloaded just a moment ago

```
tar -xzvf ***.tar.gz
```
### Usage

##### Create The Key 

*The internet for private of IPFS that must need key of Shared.Create key*  

1. Get the tool of key
```
go get -u github.com/Kubuxu/go-ipfs-swarm-key-gen/ipfs-swarm-key-gen
```

2. Create key  

```
ipfs-swarm-key-gen > ~/.ipfs/swarm.key
```

3. Transfer file that of key  

```
scp ~/.ipfs/swarm.key <username>@<ip address>:<filepath>
```

##### Init  

1. set the path of environment variable   
```
export IPFS_PATH=~/.ipfs/

```

2. init ipfs  
```
ipfs init
```

##### Check Info  
```
ipfs cat /ipfs/<hash of ipfs>/readme
```

##### Delete peer of default
```
ipfs bootstrap rm —all
```

##### Add peer  
Add one of the peer that you have.  
```
ipfs bootstrap add/ip4/<ip address>/tcp/<port>/ipfs/<peer identity>
```

##### Start Peer  
```
ipfs daemon
```
