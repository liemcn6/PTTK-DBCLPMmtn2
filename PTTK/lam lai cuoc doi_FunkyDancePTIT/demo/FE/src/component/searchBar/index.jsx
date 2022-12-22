import {useState} from 'react';

const SearchBar = (props) => {
    const {style, className, placeholder, onSubmit} = props;

    const [keyword, setKeyword] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        onSubmit(keyword);
        return;
    };

    const handleInputChange = (e) => {
        setKeyword(e.currentTarget.value);
    };

    return (
        <form
            style={style}
            className={`search-bar flex items-center rounded-3xl shadow-lg border-2 border-green-300 ${className}`}
            onSubmit={handleSubmit}
        >
            <input
                className='w-full px-5 py-1 bg-transparent text-gray-400 focus:text-gray-800 outline-none focus:outline-none'
                type='text'
                value={keyword}
                onChange={handleInputChange}
                placeholder={placeholder}
            />
            <button
                className='px-3 py-1 rounded-r-3xl text-white font-Raleway font-semibold bg-green-300 outline-none focus:outline-none'
                type='submit'
            >
                Search
            </button>
        </form>
    );
};

export default SearchBar;
