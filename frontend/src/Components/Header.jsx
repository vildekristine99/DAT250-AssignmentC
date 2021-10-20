import React from "react";
import { useCallback } from "react";

const Header = () => {

    return (
        <div>
    <div className="header">
        <h1>Votesphere</h1>
    </div>
        <div className="login"><a href="/login">Log in / Register</a></div>
    </div>

    );
}

export default Header;