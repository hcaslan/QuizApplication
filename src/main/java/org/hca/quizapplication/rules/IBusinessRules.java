package org.hca.quizapplication.rules;

import java.lang.reflect.Field;
import java.util.List;

/**
 * These classes provide a structured approach to validate entities and perform custom validation checks specific to the project's requirements
 */
public interface IBusinessRules{
    void checkIfNull(String value);
    void checkIfNull(Long value);
    void checkIfListEmpty(List<String> list);
    void validateFieldLength(String value, Field field);
}
