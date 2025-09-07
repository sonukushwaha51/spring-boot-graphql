# spring-boot-graphql

# Validate schema
`curl -X POST localhost:8080/graphql \
-H "Content-Type: application/json" \
-d '{"query":"{__schema{types{name}}}"}'`

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