# Looqbox Backend Challenge

## Introduction

This is a simple API to get pokemon from the [PokeAPI](https://pokeapi.co/) with SpringBoot.

## How to use

- GET **/pokemons?query={pokemon}&sort={type}**

      - query: name of the pokemon to search
      - sort: sort by ALPHABETICAL or LENGTH (if not specified, it will be sorted by ALPHABETICAL)
Example: **/pokemons?query=bul**
```json
{
  "result":[
    "bulbasaur",
    "granbull",
    "snubbull",
    "tapu-bulu"
  ]
}
```

Another example: **/pokemons?query=bul&sort=LENGTH**
```json
{
  "result":[
    "snubbull",
    "granbull",
    "bulbasaur",
    "tapu-bulu"
  ]
}
```

- GET **/pokemons/highlight?query={pokemon}&sort={type}**

      - query: name of the pokemon to search
      - sort: sort by ALPHABETICAL or LENGTH type (if not specified, it will be sorted by ALPHABETICAL)

Example: **/pokemons/highlight?query=bul**

```json
{
  "result": [
    {
      "pokemon": {
        "name": "bulbasaur",
        "url": "https://pokeapi.co/api/v2/pokemon/1/"
      },
      "highlight": "<pre>bulba</pre>saur"
    }
  ]
}
```

## Others

- Sorting Algorithm: **Bubble Sort**
- Logger: **Log4j2**