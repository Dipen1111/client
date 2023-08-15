package com.client.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerResponse {
    private HttpStatus httpStatus;
    private String message;
    private Object data;

    public static ServerResponseBuilder builder() {
        return new ServerResponseBuilder();
    }

    public static class ServerResponseBuilder {

        private Object data;
        private HttpStatus httpStatus;
        private String message;

        public ServerResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ServerResponseBuilder httpStatus(HttpStatus status) {
            this.httpStatus = status;
            return this;
        }

        public ServerResponseBuilder data(Object data) {
            this.data = data;
            return this;
        }

        public ServerResponse build() {
            ServerResponse response = new ServerResponse();
            response.data = this.data;
            response.message = this.message;
            response.httpStatus = this.httpStatus;
            return response;
        }
    }
}
