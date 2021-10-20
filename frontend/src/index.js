import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';

import Routes from "./Routes";
import { BrowserRouter as Router } from 'react-router-dom';

class Index extends React.Component {

  render () {
    return (
    <div>
      <Router>

        <Routes/>
      </Router>
      
    </div>
    );
  };

  
}

ReactDOM.render(<Index />, document.getElementById("root"));



// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

//<App />