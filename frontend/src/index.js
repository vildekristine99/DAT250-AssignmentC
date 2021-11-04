import React from 'react';
import ReactDOM from 'react-dom';
import './styling/index.scss';
import EnterPin from './Components/EnterPin.jsx';
import Header from './Components/Header.jsx';


class Index extends React.Component {

  render() { 
		return (
			<div><Header /><EnterPin /></div>
		)
	}  
}

ReactDOM.render(
  <Index />,
  document.getElementById('react')
)

export default Index;