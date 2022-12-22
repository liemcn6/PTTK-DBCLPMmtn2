import './index.css';

const Span = (props) => {
    const {className, children} = props;
    return <span className={className}>{children}</span>;
};

const Anchor = (props) => {
    const {link, className, children} = props;
    return (
        <a href={link} className={className}>
            {children}
        </a>
    );
};

const Image = (props) => {
    const {ele: Ele, link, children} = props;
    return (
        <Ele link={link} className='image cover'>
            {children}
        </Ele>
    );
};

const ImageCtn = (props) => {
    const {className, link, src, alt, notLink} = props;
    return (
        <div className={`image-ctn ${className}`}>
            <Image ele={notLink ? Span : Anchor} link={link}>
                <img src={src} alt={alt}/>
            </Image>
        </div>
    );
};

export default ImageCtn;
