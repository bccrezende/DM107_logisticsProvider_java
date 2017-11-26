# Trabalho Final DM107 - Java

## Login da aplicação

Para autenticar no sistema:
* Login: admin
* Senha: admin

## Media type considerado no projeto
* Media type: contentType/Json

## APIs do Sistema

### Obter uma entrega apartir de um número do pedido
```sh
GET
http://localhost:8080/logisticsProvider/rest/apiDelivery/delivery/{id}
```

### Criar uma entrega 
```sh
POST
http://localhost:8080/logisticsProvider/rest/apiDelivery/adddelivery
```
Parametros:
```sh
{
clientId: int, 
orderNumber: int,
receiverName: string,
receiverCpf: string,
date: string
}
```
