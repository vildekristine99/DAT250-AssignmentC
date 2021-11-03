import React from "react";
import { useCallback } from "react";

const Header = () => {

    return (
        <div className = "header">
            <div className="title">
                <h1>Votesphere</h1>
            </div>
                <div className="login"><a href="/login">Log in</a></div>
                <div className="register"><a href="/register">Register</a></div>
        </div>

    );
}

export default Header;