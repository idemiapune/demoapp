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

Try `http://localhost:8080/` on a browser and following will be the output in browser:

`Host Name:- $hostname | IP Address:- $ip_address | OS Name:- linux | Message:- Hello from Docker Container 1`


