import React from 'react';
import ReactDOM from 'react-dom';
import './styling/index.scss';

import reportWebVitals from './tests/reportWebVitals';
import Routes from "./Routes";

import App from './App';
import { HashRouter } from 'react-router-dom';

//class Index extends React.Component {
/*
  render () {
    return (
    <div>
      <HashRouter>

        <Routes/>
      </HashRouter>
      
    </div>
    );
  };
}
*/
  


ReactDOM.render(
      <HashRouter>
        <App/>
      </HashRouter>
      , document.getElementById("root"));



// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
//reportWebVitals();

//<App />