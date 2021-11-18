import React from "react";
import { Route, Switch } from "react-router-dom";
import Header from "./Components/Header.jsx";
import Register from "./Components/Register.jsx";
import EnterPin from './Components/EnterPin.jsx';
//import Login from './Components/Login.jsx';
import PublishPoll from "./Components/PublishPoll.jsx";
import UserHome from "./Components/UserHome.jsx";
import UserPolls from "./Components/UserPolls.jsx";
import LoginComponent from "./Components/Security/LoginComponent.jsx";
import ViewPoll from "./Components/ViewPoll.jsx";
import AuthenticatedRoutes from "./AuthenticatedRoutes.js"



class Routes extends React.Component {
  

  render() {
    return (
      <Switch>
        <Route exact path="/">
          <Header text="Log in" link="/#/login"/>
          <EnterPin />
        </Route>
        <Route exact path="/login">
          <Header text="Go back" link="/"/>
          <LoginComponent />
        </Route>
        <Route path="/register">
          <Header  text="Log in" link="/#/login"/> 
          <Register />
        </Route>
        <AuthenticatedRoutes path="/publishPoll">
          <Header  text="Go back" link="/#/userHome"/>
          <PublishPoll />
        </AuthenticatedRoutes>
        <Route path="/userHome">
          <Header  text="Log out" link="/"/>
          <UserHome />
        </Route>
        <Route path="/userPolls">
          <Header  text="Go back" link="/#/userHome"/>
          <UserPolls />
        </Route>
        <Route path="/viewPoll">
          <Header text="Log out" link="/#/viewPoll"/>
          <ViewPoll />
        </Route>
      </Switch>
    );
  }
    
    
}
export default Routes;