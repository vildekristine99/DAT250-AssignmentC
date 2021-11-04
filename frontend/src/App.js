import React from 'react';
import ReactDOM from 'react-dom';
import './styling/_app.scss';
import reportWebVitals from './reportWebVitals';

import Routes from "./Routes";
import { HashRouter } from "react-router-dom";
import EnterPin from './Components/EnterPin.jsx';
import Header from './Components/Header.jsx';

class App extends React.Component {

  render() { 
		return (
      <div><Header /><EnterPin /></div>
		)
	}  
}

ReactDOM.render(
  <App />,
  document.getElementById('react')
)

export default App;

