import React from "react";

const Login = () => {
  return (
    <div className="inputDiv">
      <input type="text" placeholder="Username" />
      <input type="text" placeholder="Password" />

      <div className="wrap">
        <div className="line" />
        <p>or</p>
        <div className="line" />
      </div>

      <button className="loginButton">Log in with Facebook</button>
      <button className="loginButton">Log in with Google</button>
      <p>Don't have an account? 
        <a href="/register" className = "loginReg">Register</a>
      </p>
    </div>
  );
};

export default Login;

/**
 *
 * hello
 *
 */
