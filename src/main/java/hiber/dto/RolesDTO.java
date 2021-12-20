package hiber.dto;

import hiber.model.Role;

import java.util.Set;

public class RolesDTO {
    private Set<Role> dtoRoles;

    public RolesDTO() {
    }

    public RolesDTO(Set<Role> dtoRoles) {
        this.dtoRoles = dtoRoles;
    }

    public Set<Role> getDtoRoles() {
        return dtoRoles;
    }

    public void setDtoRoles(Set<Role> dtoRoles) {
        this.dtoRoles = dtoRoles;
    }


}
