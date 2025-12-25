# spring-boot-graphql

# Validate schema
`curl -X POST localhost:8080/graphql \
-H "Content-Type: application/json" \
-d '{"query":"{__schema{types{name}}}"}'`

# Allow access to all users

`gcloud run services add-iam-policy-binding spring-boot-graphql --member="allUsers" --role="roles/run.invoker" --region=us-central1`

# Running query from GraphiQl

`http://localhost:8080/graphiql?path=/graphql`

`query MyQuery {
    query {
        authors(ids: [1]) {
            bio
            id
            name
        }
    }
}`

`mutation MyMutation {
  createReview(review: {id: 102, rating: 5, userId: 10, bookId: 10, comment: "Liked it"}) {
    message
    status
    timestamp
  }
}`

# Git flow Maven plugin

`git checkout develop`

`git pull`

`git checkout main`

`git pull`

`git checkout develop`

`mvn gitflow:release-start`

# Select release version and then

`mvn gitflow:release-finish`


# Start redis in local from CLI
`Install redis server`

`redis-server`

`redis-cli`

# Read from redis

`GET <keyName>`

# Delete all from Redis

`FLUSHALL`

# Read HASH FROM REDIS
`KEYS *` - Get all keys in HASH
`TYPE authors` - Get type of hashKey
`HGETALL authors` - Get all cached values inside a key
`HGET authors authors_10` - Get cached value of specific key

# Create Redis Instance

`gcloud redis instances create --project=eighth-saga-474816-a6  graphql-instance --tier=standard --size=16 --region=us-central1 --redis-version=redis_7_2 --network=projects/eighth-saga-474816-a6/global/networks/default --connect-mode=DIRECT_PEERING --display-name="GraphQL instance"`