package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    String title, code, description, type, memberType, access, group;
}
