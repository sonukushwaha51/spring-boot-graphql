# spring-boot-graphql

# Validate schema
`curl -X POST localhost:8080/graphql \
-H "Content-Type: application/json" \
-d '{"query":"{__schema{types{name}}}"}'`

# Running query from GraphiQl

`http://localhost:8080/graphiql?path=/graphql`

`query MyQuery {
    query {
        authors(names: ["sonu"]) {
            bio
            id
            name
        }
    }
}`