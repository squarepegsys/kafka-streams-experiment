## Kafka Stream experiment

this is really a playground for me to muck with Kafka Streams, a library that Confluent seems proud of. It's a Groovy project because that is how I like to write Java :) but really it's very understandable to Java devs

I use Kafkacat to interface with Kafka on the CLI - https://github.com/edenhill/kcat  because I think it's easier

I'm using Confluent platform to run Confluent locally. you can use Docker or whatever.

I'm using [this generic customers-100.csv](https://github.com/datablist/sample-csv-files/blob/main/files/customers/customers-100.csv) for sample data.

### Usage

Send the records:

``` sh
cat  customers-100.csv|  kafkacat -P -t stream.example -b  localhost:9092
```

process the records with the app:

``` sh
./gradlew run 

```

You will have to Ctrl-C out of this 

now dump the contents

``` sh
kafkacat -C -t UppercasedTextLinesTopic   -b localhost:9092
```
