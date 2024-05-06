package org.hca.quizapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblquestion")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 200, message
            = "questionText must be between 3 and 2024 characters")
    @NotNull(message = "questionText cannot be null")
    private String questionText;

    @NotNull(message = "answers cannot be null")
    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Answer> answers;
}
