import React from "react";
import lineImageSvg from "../logos/line.svg";
import AuthService from "../Service/auth.service";

class Register extends React.Component {

    constructor(props) {
        super(props)

        this.state = {
            username: '',
            firstname: '',
            lastname: '',
            password: ''
        }

        this.handleChange = this.handleChange.bind(this)
        this.registerClicked = this.registerClicked.bind(this)
    }


    handleChange(event) {
        this.setState(
            {
                [event.target.name]: event.target.value
            }
        )
    }

    registerClicked() {
        AuthService.register(
            this.state.username,
            this.state.firstname,
            this.state.lastname,
            this.state.password)
            .then(value => console.log("Register successfull: ",value));
    }

    render() {
        return (
            <div className="inputDiv">

                <div className="lineWrap">
                    <img src={lineImageSvg} class="imageline1" alt="line"/>
                    <p>Create a user!</p>
                    <img src={lineImageSvg} class="imageline2" alt="line"/>
                </div>

                <div onChange={this.handleChange}>
                    <input type="text" name="firstname" placeholder="First name"/>
                    <input type="text" name="lastname" placeholder="Last name"/>
                    <input type="text" name="username" placeholder="username"/>
                    <input type="password" name="password" placeholder="Password"/>
                </div>
                <button className="loginButton" onClick={this.registerClicked}>Register</button>
            </div>

        );
    }


}

export default Register;
