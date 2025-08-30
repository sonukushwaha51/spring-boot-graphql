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

# Git flow Maven plugin

`git checkout develop`

`git pull`

`git checkout main`

`git pull`

`git checkout develop`

`mvn gitflow:release-start`

# Select release version and then

`mvn gitflow:release-finish`