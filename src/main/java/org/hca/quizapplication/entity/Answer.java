package org.hca.quizapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblanswer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 2024, message
            = "answerText must be between 3 and 2024 characters")
    @NotNull(message = "answerText cannot be null")
    private String answerText;

    private boolean correctAnswer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
