import React from "react"; 

class PublishPoll extends React.Component {

    constructor(props) {
        super(props)

        this.state = {
            pollName: '',
            isPublic: true,
        }

        this.handleChange = this.handleChange.bind(this)
        this.publishButtonClicked = this.publishButtonClicked.bind(this)
    }
   

    handleChange(event) {
        this.setState(
            {
                [event.target.name]
                    : event.target.value
            }
        )
        console.log(event.target.value)
    }

    
    publishButtonClicked() {

    }

    render() {
        return (
            <div className="publishInputDiv">
                <p className="descriptionBig" > Poll description</p>
                
                <input className="largeInput" name="pollName" type="text" placeholder="...(max 250 characters)" onChange={this.handleChange}/>
        
                <div className="radioDiv" onChange={this.handleChange}>
                    <input className="radio" type="radio" id="radio1" name="isPublic" value="true" />
                    <label className="labelRadio" for="radio1">Public</label>
        
                    <input className="radio" type="radio" id="radio2" name="isPublic" value="false" />
                    <label className="labelRadio" for="radio2">Private</label>
                </div>
                
        
                <a className="blackButton" onClick={this.publishButtonClicked}> Publish Poll </a>
                <p><a href="#/userHome"> Cancel </a></p>
            </div>
        
            );
    }
}

export default PublishPoll; 


