import React from "react";
import { Route, Switch } from "react-router-dom";
import Header from "./Components/Header.jsx";
import Register from "./Components/Register.jsx";
import EnterPin from './Components/EnterPin.jsx';
import Login from './Components/Login.jsx';
import PublishPoll from "./Components/PublishPoll.jsx";
import UserHome from "./Components/UserHome.jsx";
import UserPolls from "./Components/UserPolls.jsx";

export default function Routes(props) {
    
    return (
      <Switch>
        <Route exact path="/">
          <Header />
          <EnterPin />
        </Route>
        <Route path="/login">
          <Header />
          <Login />
        </Route>
        <Route path="/register">
          <Header />
          <Register />
        </Route>
        <Route path="/publishPoll">
          <Header />
          <PublishPoll />
        </Route>
        <Route path="/userHome">
          <Header />
          <UserHome />
        </Route>
        <Route path="/userPolls">
          <Header />
          <UserPolls />
        </Route>
      </Switch>
    );
  }