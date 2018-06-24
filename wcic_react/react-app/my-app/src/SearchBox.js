import React from 'react';
import Autosuggest from 'react-autosuggest';
import 'bootstrap/dist/css/bootstrap.min.css';
import './searchbox.css';

const theme = {input: 'searchbox-input col-lg list-group-item',
                suggestionsContainer: 'searchbox-suggestionContainer',
                suggestionsList: 'searchbox-suggestionList',
                suggestion: 'searchbox-suggestion',
                suggestionHighlighted: 'suggestion-highlighted'
                }

// When suggestion is clicked, Autosuggest needs to populate the input
// based on the clicked suggestion. Teach Autosuggest how to calculate the
// input value for every given suggestion.
const getSuggestionValue = suggestion => suggestion.name;

// Use your imagination to render suggestions.
const renderSuggestion = suggestion => (
  <div>
    {suggestion.name}
  </div>
);

class SearchBox extends React.Component {
  constructor(props) {
      super(props);
      this.onSuggestionSelected = this.onSuggestionSelected.bind(this);
      this.onSuggestionsFetchRequested = this.onSuggestionsFetchRequested.bind(this);
      // Autosuggest is a controlled component.
      // This means that you need to provide an input value
      // and an onChange handler that updates this value (see below).
      // Suggestions also need to be provided to the Autosuggest,
      // and they are initially empty because the Autosuggest is closed.
      this.state = {
        value: '',
        suggestions: []
      };
    }

    onChange = (event, { newValue }) => {
        this.setState({
          value: newValue
        });
      };

      // Autosuggest will call this function every time you need to update suggestions.
      // You already implemented this logic above, so just use it.
      onSuggestionsFetchRequested = ({ value }) => {
        const inputValue = value.trim().toLowerCase();
        const inputLength = inputValue.length;

        inputLength === 0 ? this.setState({suggestions:[]}):
           fetch("http://localhost:8080/ingredient/search/nameStartingWith?term="+inputValue+"&page=1&size=10")
            .then(response => response.json() )
            .then(
              parsedJson =>
              {
                this.setState({suggestions: parsedJson._embedded.ingredient});
              }
            );
      };

      // Autosuggest will call this function every time you need to clear suggestions.
      onSuggestionsClearRequested = () => {
        this.setState({
          suggestions: []
        });
      };

      onSuggestionSelected(event, options){
        this.props.onIngredientSelected(options.suggestionValue)
      }

      render() {
        const { value, suggestions } = this.state;

        // Autosuggest will pass through all these props to the input.
        const inputProps = {
          placeholder: 'Aggiungi un ingrediente...',
          value,
          onChange: this.onChange
        };

        // Finally, render it!
        return (
          <Autosuggest
            suggestions={suggestions}
            onSuggestionsFetchRequested={this.onSuggestionsFetchRequested}
            onSuggestionsClearRequested={this.onSuggestionsClearRequested}
            getSuggestionValue={getSuggestionValue}
            renderSuggestion={renderSuggestion}
            onSuggestionSelected={this.onSuggestionSelected}
            inputProps={inputProps}
            theme={theme}
          />
        );
      }
}


export default SearchBox
