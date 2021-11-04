import React from "react"; 

const Register = () => {

    return (
        <div className="inputDiv">
            <div className="line"/><p>Create a user!</p><div className="line"/>
            <input type="text" placeholder="First name"/>
            <input type="text" placeholder="Last name"/>
            <input type="text" placeholder="Email"/>
            <input type="text" placeholder="Password"/>
            <p className = "registerBtn">Register</p>
        </div>

    ); 

}

export default Register; 
