package com.synergisticit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Enumerated(value = EnumType.STRING)
public enum Categories {
    NONFICTION, FICTION, MYSTERY, ROMANCE, THRILLER
}
