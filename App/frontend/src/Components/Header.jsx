import React from "react";
import AuthService from "../Service/auth.service";

class Header extends React.Component {
    
    
    render() {
        return (
            <div className = "header">
                <div className="title">
                    <h1>Votesphere</h1>
                </div>
                    <div className="login"><a href={this.props.link}>{ this.props.text }</a></div>
            </div>
        )
    }

    
 
}

export default Header;