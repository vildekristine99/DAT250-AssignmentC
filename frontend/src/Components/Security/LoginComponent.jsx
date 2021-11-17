import React, { Component } from 'react'
import AuthService from '../../Service/auth.service.js';

import {withRouter} from 'react-router-dom';

class LoginComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            username: '',
            password: '',
            hasLoginFailed: false,
            message: ''
        }

        this.handleChange = this.handleChange.bind(this)
        this.loginClicked = this.loginClicked.bind(this)
    }


    handleChange(event) {
        this.setState(
            {
                [event.target.name]
                    : event.target.value
            }
        )
    }

    loginClicked() {
        AuthService.login(this.state.username, this.state.password)
            .then(value => console.log("Login successful: ", value))
    }

    render() {
        return (

            <div>
                <div className="inputDiv">


                    <input type="text" placeholder="Username" name="username" onChange={this.handleChange}/>
                    <input type="password" placeholder="Password" name="password" onChange={this.handleChange}/>
                    <button className="loginButton" onClick={this.loginClicked}>Log in</button>
                    <p>Don't have an account?
                        <a href="/#/register" className = "loginReg">Register</a>
                    </p>
                </div>
            </div>
        )
    }
}

export default withRouter(LoginComponent)

/*
<div className="wrap">
                    <div className="line" />
                    <p>or</p>
                    <div className="line" />
                </div>

                <button className="loginButton">Log in with Facebook</button>
                <button className="loginButton">Log in with Google</button>
*/