import React from 'react';
import "./Login.css";
import Header from "./todo-header/Header";
import {Field, reduxForm} from "redux-form";

function Login() {

    const onSubmit = (formData) => {
        console.log(formData);
    };

    return (
        <div>
            <Header/>
            <div className="login-container">
                <LoginReduxForm onSubmit={onSubmit}/>
            </div>
        </div>
    )
}

const LoginReduxForm = reduxForm({form: 'login'})(LoginForm);

function LoginForm(props) {
    return (
        <form className="login-form" onSubmit={props.handleSubmit}>
            <Field placeholder={"Login"} component={"input"} name={"login"} className="login-input"/>
            <Field placeholder={"Password"} component={"input"} name={"password"} className="login-input"/>
            <div className="forms-buttons">
                <button className="login-button">Sign In</button>
                <button className="login-button">Sign Up</button>
            </div>
        </form>
    )
}

export default Login;