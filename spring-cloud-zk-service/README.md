###   zk 注册于服务发现

####  查看服务注册状态

ZkServer  就是我们注册的服务名称,该节点是临时节点

```
ls /services/ZkServer

[zk: localhost:2181(CONNECTED) 11] ls /services/ZkServer
[ccb64156-4aa3-4d17-b79d-5a2601587c60]

get /services/ZkServer/ccb64156-4aa3-4d17-b79d-5a2601587c60


```

服务停止

```
[zk: localhost:2181(CONNECTED) 17] ls /services/ZkServer
[]

```


