package com.amorix.Amorix.AI.Entity;

import com.amorix.Amorix.AI.Enum.ChatEventType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "chat_events")
@Builder
public class ChatEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    ChatMessage chatMessage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ChatEventType chatEventType;

    @Column(nullable = false)
    Integer sequenceOrder;
    @Column(columnDefinition = "text")
    String content;

    String filePath;

    @Column(columnDefinition = "text")
    String metaData;


}
