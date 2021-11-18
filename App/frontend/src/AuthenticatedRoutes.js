import React from "react";
import { Route, Redirect } from "react-router-dom";
import AuthService from "./Service/auth.service.js";
import { useEffect, useState } from "react";

const AuthenticatedRoutes = ({ component: Component, ...rest }) =>  {
  
  const [userloggedin, setUserloggedin] = useState([]);

  useEffect(() => {
    setUserloggedin(!AuthService.isUserNotLoggedin());
    console.log(userloggedin);
  }, [userloggedin]);


   
  if (userloggedin) {
      return <Route {...rest} render={props => (<Component {...props}/>)}/>
  } else {
      return <Redirect to="/login" />
  }
  
}
export default AuthenticatedRoutes;