package test.spring.bean;

import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }


    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

}
