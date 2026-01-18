/*
* @author Nader Abi Younes
* @date 01/18/26
* @purpose This java function serves as the lambda function to query dynamodb for the number of 
* views and increment it. Once incremented the new number is saved to dynamodb and returned 
* for it to be displayed.
*/
package com.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.Map;

public class CounterViews {

    private final DynamoDbClient dynamoDb = DynamoDbClient.create();

    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {

        String itemId = event.getQueryStringParameters() != null
                ? event.getQueryStringParameters().getOrDefault("itemId", "default-item")
                : "default-item";

        UpdateItemRequest request = UpdateItemRequest.builder()
                .tableName("veiw-count-table")
                .key(Map.of("id", AttributeValue.builder().s(itemId).build()))
                .updateExpression("ADD #v :inc")
                .expressionAttributeNames(Map.of("#v", "views"))
                .expressionAttributeValues(Map.of(":inc", AttributeValue.builder().n("1").build()))
                .returnValues(ReturnValue.UPDATED_NEW)
                .build();

        UpdateItemResponse response = dynamoDb.updateItem(request);

        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody(response.attributes().get("views").n());
    }
}
