package ua.stryghul.Wavelength;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class MyWebSocketHandler implements WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // This method is called when a new WebSocket connection is established.
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        // This method is called when a new WebSocket message is received.
        Object payload = message.getPayload();
        if (payload instanceof String) {
            String textPayload = (String) payload;
            System.out.println(textPayload);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // This method is called when a transport error occurs (e.g. the connection is lost).
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // This method is called when a WebSocket connection is closed.
    }

    @Override
    public boolean supportsPartialMessages() {
        // This method should return true if your handler supports partial messages (not applicable in this case).
        return false;
    }
}