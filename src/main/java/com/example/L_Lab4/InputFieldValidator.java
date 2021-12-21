package com.example.L_Lab4;

import org.apache.commons.lang3.StringUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("inputFieldValidator")
public class InputFieldValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o == null || StringUtils.isBlank(o.toString())){
            throw new ValidatorException(new FacesMessage("Значение не может быть пустым"));
        }
    }
}
