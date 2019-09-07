# demoapp

<b>Cleanup:</b>  mvn clean

<b>Changing the version/tag of docker image: </b>

```
Change <tag>x.0</tag> in line number 36 to 39 in pom.xml of the project.

 <configuration>
     <repository>${docker.image.prefix}/${project.artifactId}</repository>
     <tag>1.0</tag>
 </configuration>
 ```

<b>Creating docker image:</b>  mvn install dockerfile:build

<b> Pushing the image to dockerhub: </b>

`docker login --username=$user_name --password=$password`

`docker push $user_name/$image_name:$image_tag`

<b> Running the docker image: </b>

`docker run -d --name $container_name -p 8080:8080 $user_name/$image_name:$image_tag`

or if you want to mount the volume for accessing log files on the host

```
docker run -d --name $container_name -p 8080:8080 
-v /Users/name/demoapplogs:/var/applogs $user_name/$image_name:$image_tag
```

<b> Connecting to shell of the running docker container (it has a ash shell as the base OS is alpine): </b>

`docker exec -it $container_name_or_id /bin/ash`

<b> Test the service: </b>

1. Try `http://localhost:8080/` on a browser and following will be the output in browser:

`Host Name:- $hostname | IP Address:- $ip_address | OS Name:- linux | Message:- Hello from Docker Container 2`

2. Try `http://localhost:8080/genlogs` on a browser and following will be visible in log file at /var/applogs/app.log:

```
2019-09-07 19:14:15.620 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 1
2019-09-07 19:14:16.625 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 2
2019-09-07 19:14:17.630  INFO 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : SUCCESS_MARKER demoapp log statement number 3
2019-09-07 19:14:18.631 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 4
2019-09-07 19:14:19.633 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 5
2019-09-07 19:14:20.638  INFO 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : SUCCESS_MARKER demoapp log statement number 6
2019-09-07 19:14:21.641 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 7
2019-09-07 19:14:22.645 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 8
2019-09-07 19:14:23.651  INFO 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : SUCCESS_MARKER demoapp log statement number 9
2019-09-07 19:14:24.655 ERROR 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : ERROR_MARKER demoapp log statement number 10
2019-09-07 19:14:25.656 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 11
2019-09-07 19:14:26.659  INFO 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : SUCCESS_MARKER demoapp log statement number 12
2019-09-07 19:14:27.661 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 13
2019-09-07 19:14:28.662 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 14
2019-09-07 19:14:29.666  INFO 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : SUCCESS_MARKER demoapp log statement number 15
2019-09-07 19:14:30.667 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 16
2019-09-07 19:14:31.671 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 17
2019-09-07 19:14:32.677  INFO 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : SUCCESS_MARKER demoapp log statement number 18
2019-09-07 19:14:33.677 DEBUG 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : DEBUG_MARKER demoapp log statement number 19
2019-09-07 19:14:34.678 ERROR 1407 --- [nio-8080-exec-1] in.pune.pradyroy.DemoApp                 : ERROR_MARKER demoapp log statement number 20
```

