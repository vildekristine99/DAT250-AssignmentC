import React, { Component } from 'react'
import AuthenticationService from './AuthenticationService.js';

import {withRouter} from 'react-router-dom';

class LoginComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            username: '',
            password: '',
            hasLoginFailed: false,
            showSuccessMessage: false
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
        
            /*if(this.state.username==='in28minutes' && this.state.password==='dummy'){
                this.props.history.push('/userHome')
                //this.setState({showSuccessMessage:true})
                //this.setState({hasLoginFailed:false})
            }
            else {
                this.setState({showSuccessMessage:false})
                this.setState({hasLoginFailed:true})
            }
            */
            AuthenticationService
                .executeBasicAuthenticationService(this.state.username, this.state.password)
                .then(() => {
                    AuthenticationService.registerSuccessfulLogin(this.state.username, this.state.password)
                    this.props.history.push('/userHome')
                }).catch(() => {
                    this.setState({ showSuccessMessage: false })
                    this.setState({ hasLoginFailed: true })
                })
            
        
    }

    render() {
        return (
            
            <div>
                <div className="inputDiv">
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                    {this.state.showSuccessMessage && <div>Login Sucessful</div>}

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