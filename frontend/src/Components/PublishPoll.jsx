import React from "react"; 

const PublishPoll = () => {

    return (
    <div className="publishInputDiv">
        <p className="descriptionBig"> Poll description</p>
        <input className="largeInput" type="text" placeholder="...(max 250 characters)" />

        <div className="radioDiv">
            <input className="radio" type="radio" id="radio1" name="answer" value="Public" checked />
            <label className="labelRadio" for="radio1">Public</label>

            <input className="radio" type="radio" id="radio2" name="answer" value="Private" />
            <label className="labelRadio" for="radio2">Private</label>
        </div>
        

        <a href = "#" className="blackButton"> Publish Poll </a>
        <p> Cancel </p>
    </div>

    );

}
export default PublishPoll; 


