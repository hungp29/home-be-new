#### Configuration
- In local, you can update your database connection information into `docker-compose.local.yaml`
#### Command to run
##### Run with default flyway.conf in local
```
docker-compose -f docker-compose.local.yaml run flyway migrate
```
##### Run without flyway.conf
```
docker-compose run flyway \
  -url=jdbc:postgresql://db:5432/mydb \
  -user=user \
  -password=password \
  -schemas=public \
  -locations=filesystem:/flyway/sql \
  migrate
```

