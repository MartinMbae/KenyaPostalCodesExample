# Kenyan Postal Codes

KenyanPostalCodes is an android library that displays all the postal codes in Kenya for selection.

The library has;
 
- Name eg South Kinangop
- Postal Code eg 20319




## Installation

Add this library to your dependencies

```bash
    implementation 'com.martinmbae.kenyan.postalcodes:library:1.0.1'
```

## Usage

Add the following imports to your project

```java

import studios.luxurious.kenyanpostalcodes.activities.KenyaPostalCodes;
import studios.luxurious.kenyanpostalcodes.activities.PostalAreaSelected;
import studios.luxurious.kenyanpostalcodes.models.PostalArea;
```

To the display all postal areas,simply call the method 

```java
    KenyaPostalCodes.showAllPostalAreas(MainActivity.this, 
                true, //Arranges by alphabetical order. When false they will be arranges using thei postal codes in assending order.
                "Show Post Codes", // Dialog title
                new PostalAreaSelected() {
            @Override
            public void OnPostalAreaSelected(PostalArea selectedPostalArea) {
                
                String name =  selectedPostalArea.getAreaName();
                String code = selectedPostalArea.getAreaCode();
                //You can proceed to use them in your code
            }
        });

```

## Screenshots

###### Ordered by postal name
<img src="https://github.com/MartinMbae/KenyaPostalCodesExample/blob/master/screenshots/scr1.png" width="300" height="auto"> 


###### Ordered by postal code
<img src="https://github.com/MartinMbae/KenyaPostalCodesExample/blob/master/screenshots/scr2.png" width="300" height="auto"> 


## License
MIT License

```
Copyright (c) [year] [fullname]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
