package com.example.infs3605;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Response {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("additionalType")
    @Expose
    private List<String> additionalType = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("physicalDescription")
    @Expose
    private String physicalDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAdditionalType() {
        return additionalType;
    }

    public void setAdditionalType(List<String> additionalType) {
        this.additionalType = additionalType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPhysicalDescription() {
        return physicalDescription;
    }

    public void setPhysicalDescription(String physicalDescription) {
        this.physicalDescription = physicalDescription;
    }

    public static String artDetailsJson = "{ \"id\" : \"145764\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Dot painting\",    “region”  :  “Canberra, Australian Capital Territory”,    “creator”  :  “Leonora Napparulla”,    \"identifier\" : \"IR 4528.0267\",    \"physicalDescription\" : \"A colour dot painting on canvas featuring a pattern of concentric circles, and half circle shapes. In the centre are brown concentric circles with half circles around the outside circle. The top and bottom of the middle circles are circles consisting of small half circle shapes. To the left and right of the middle circle are circles consisting of large half circle shapes. On the reverse handwritten in black ink ‘C-1701 FRAME 357. Also on the reverse is a silver sticker from the ‘ABORIGINAL AND TORRES STRAIT INSLANDER COMMISSION’ with the ATSIC asset number ‘C-1701’. Attached the reverse with brown tape is a black label with white text ‘Title unknown Leonora Napparulla ...’. The canvas is stretched over a strainer, has a backing board and a brown wooden frame.\" },  { \"id\" : \"146846\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Contemporary painting with heads, eyes and colourful wavy lines.\",    “region”  :  “Canberra, Australian Capital Territory”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.1573\",    \"physicalDescription\" : \"A colour painting on paper featuring vertical columns of green heads with one eye. In a border surrounding the central image are colourful wavy lines with yellow dots above. On the reverse is a green framing sticker and a white sticker with the text: ‘PM & C SERVICES 000352’. The work features a wooden frame and is surrounded by a white matt board.\"},  { \"id\" : \"145711\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Dot painting of  a snake, lizard and two marsupials\",    “region”  :  “Perth, Western Australia”,    “creator”  :  “Unknown”,    \"identifier\" : \"IR 4528.0214\",    \"physicalDescription\" : \"A painting on canvas board featuring a snake, lizard and two marsupials with pointy ears. The snake is brown with white, red and yellow lines and yellow dots. The two marsupials have brown and yellow cross hatched stripes. The background has a red, brown and whitewash with red, white and brown dots filling the empty space. On the back is a framer’s stamp. The painting is under glass with black and brown mats and a wooden frame painted black.\"},  { \"id\" : \"147373\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Dot painting of waterways\",    “region”  :  “Canberra, Australian Capital Territory”,    “creator”  :  “Johnny W. Tjupurrula”,    \"identifier\" : \"IR 4534.0063\",    \"physicalDescription\" : \"A dot painting on canvas featuring a concentric circle with black curved lines radiating to and from the circle. Above and beneath the circle are two semicircular symbols. The background of the painting is red ochre, the dots are predominantly white, yellow and red. Text on the reverse side of the frame reads ‘DAA 10029 7-7-88’. Beneath the text is an orange sticker. The canvas is block mounted, attached to a beige backing board and encased in a timber frame. A black exhibition label reads ‘Subject not recorded Johnny Warangkula Tjupurrula b. 1925...’\"},  { \"id\" : \"146055\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Dot painting of three concentric circles with fire sticks\",    “region”  :  “Adelaide, South Australia”,    “creator”  :  “Unknown”,    \"identifier\" : \"IR 4530.0021\",    \"physicalDescription\" : \"A dot painting on canvas board featuring three concentric circles half circles surrounding them. There are also vertical narrow oblong shapes with short brush strokes at the ends. There also three wider oblongs accompanied with narrow oblongs at the bottom of the painting. There is silver sticker on the reverse with text that reads ‘ABORIGINAL DEVELOPMENT COMMISSION 5 0349’. The painting mounted on a frame with wood blocks onto a hessian surface with a wooden frame.\"},  { \"id\" : \"147246\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Bark painting of a dingo surrounded by figures\",    “region”  :  “Cairns, Queensland”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.0907\",    \"physicalDescription\" : \"A colour bark painting featuring a central dingo pigmented brown with white outline. Surrounding the dingo is two long figures and several smaller figures and skulls and arms and legs on a black background. There are small white dots around the border. The bark is block mounted to a masonite painted black.\"},  { \"id\" : \"147342\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Bark painting\",    “region”  :  “Canberra, Australian Capital Territory”,    “creator”  :  “Jack Beimunumbi”,    \"identifier\" : \"2007.0053.0949\",    \"physicalDescription\" : \"A bark painting featuring segmented patterns of yellow, brown and white cross hatch markings. There is a horizontal strip across the middle of the painting with more markings and separated by a zig zag line. The painting includes a handprint motif in white near the centre.\"},  { \"id\" : \"147241\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Bark painting depicting a Wandjina figure\",    “region”  :  “Sydney, New South Wales”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.1004\",    \"physicalDescription\" : \"A painting on bark featuring a Wandjina figure with black eyes and a black nose. The figure is outlined in brown and has a dot pattern on the arms torso and legs. The bark is square at the bottom but rounded at the top. On the reverse are handwritten numbers ‘101’ and ‘AAB-80-65’.\"},  { \"id\" : \"145722\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Dot painting featuring a cross pattern with five concentric circles\",    “region”  :  “Perth, Western Australia”,    “creator”  :  “Unknown”,    \"identifier\" : \"IR 4528.0225\",    \"physicalDescription\" : \"A colour painting on canvas featuring a central circle with four smaller circles. The smaller circles are located in each of the corners and are joined to the central circle by wavy lines. The lines have white, grey, red, brown, black and orange circle dot patterns. A plus shape emerges from the centre circle behind the lines. The background is red and outlined by white dots with a black boarder. A signature ‘-H- 2002’ is in the bottom right corner. The painting has a metallic looking wooden frame.\"},  { \"id\" : \"147092\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting featuring a figure kneeling next to a plant\",    “region”  :  “Canberra, Australian Capital Territory”,    “creator”  :  “Unknown”,    \"identifier\" : \"IR 4533.0215\",    \"physicalDescription\" : \"A colour painting on paper featuring a female figure kneeling next to a type of plant. In the bottom right corner is a signature ‘[CB?] JAN 2000’. On the reverse is a piece of paper with handwritten photocopied text ‘ARTIST: WAMUT [BLINTH---?]’ and a title ‘MiMi HAVING BATH...’.  The painting is under glass, mounted on a white backing board with a brown wooden frame.\"},  { \"id\" : \"146750\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting of two goannas\",    “region”  :  “Mount Isa, Queensland”,    “creator”  :  “K Nathan”,    \"identifier\" : \"IR 4532.0268\",    \"physicalDescription\" : \"A colour painting on canvas board featuring two goannas. The goannas are outlined in brown with red forked tongues and white, red and yellow line markings on their bodies. They are surrounded by green leaves with brown line markings. The background consists of green, brown, yellow and red dotted segments. A signature ‘K.NAtHAN’ is in the bottom right corner. On the reverse is a white sticker with the number ‘43094025’ handwritten in blue text. The painting has a brown wooden frame.\"},  { \"id\" : \"146037\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting featuring Witchetty Grubs, four lizards and a snake with eggs\",    “region”  :  “Ceduna, South Australia”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.1562\",    \"physicalDescription\" : \"A colour painting on silk featuring a snake, four lizards and six white witchetty grubs. At the centre of the painting are eggs which are being circled by the snake and inturn circled by the lizards. The witchetty grubs are in two groups to the left and right of the painting. The background is pink with faded areas. The painting is under glass, has a speckled cream matt and a black wooden frame.\"},  { \"id\" : \"145749\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting of fish\",    “region”  :  “Ceduna, South Australia”,    “creator”  :  “Gletys E. Haseldine”,    \"identifier\" : \"IR 4528.0252\",    \"physicalDescription\" : \"A colour painting on canvas board featuring a school of grey fish facing to the left with a blue background. The artist signature ‘G. HASELDINE’ is in the bottom right corner. On the reverse is stuck a guarantee from ‘TIMBER CREEK PICTURE FRAMING’. The painting is under glass, has a grey matt and a washed blue wooden frame.\"},  { \"id\" : \"147302\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Bark painting depicting two female Mimis\",    “region”  :  “Wagga Wagga, New South Wales”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.0909\",    \"physicalDescription\" : \"A bark painting featuring two female figures pigmented brown with cross hatch patterns. The background is pigmented with black. At the top and bottom are cylindrical sticks bound to the bark with wool. On the reverse is handwritten text that reads ‘100 Y 89’, a paper label and ‘AAAB 78 6830’ written in black on a white paint. There are four blocks on the back of the bark painting.\"},  { \"id\" : \"146102\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting of a Cockatoo\",    “region”  :  “Cairns, Queensland”,    “creator”  :  “Gordon Landers”,    \"identifier\" : \"2007.0053.1056\",    \"physicalDescription\" : \"A painting on canvas featuring a cockatoo with its wings spread facing to the right. The cockatoo is white with yellow wings and tail with a black beak. The corners are painted grey, and the background is brown with grey dots. There are four yellow star like symbols in the corners and two under the cockatoo's wings with black and blue dots in between the white lines. There is a yellow border surrounding the cockatoo in brush strokes. On the reverse is a white sticker with handwritten text that reads ‘Room No 24 Con Room 1 Gordon Landers’. The canvas is stapled to a wooden stretcher.\"},  { \"id\" : \"145989\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Bark painting depicting a figure holding two turtles\",    “region”  :  “Darwin, Northern Territory”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.0912\",    \"physicalDescription\" : \"A painting on bark featuring a figure holding two turtles. The figure is brown with white line markings and is positioned vertically in the centre of the painting. The turtles are black with white line markings. The background consists of a white, brown and black cross hatch design. A wooden stick is attacked to the top of the bark with string. On the reverse handwritten in black ink is the text ‘APRIL 82 wa.’.\"},  { \"id\" : \"146779\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Prints\" ],    \"title\" : \"Bark painting depicting Mimi Spirits\",    “region”  :  “Brisbane, Queensland”,    “creator”  :  “Bardayal Nadjamerrek”,    \"identifier\" : \"IR 4532.0297\",    \"physicalDescription\" : \"A colour reprint on paper of an original print featuring eighteen figures on a red and black background. At the bottom is handwritten text in pencil that reads '156 500 MINI SPIRITS Lofty NABARRAYAL NADJAMERREK', followed by a black fingerprint. On the reverse is two pieces of white paper attached with tape with information about the artist and a bar code sticker that reads 'F0008537'. The print is under glass with a cream mat and wooden frame.\"},  { \"id\" : \"146076\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting of a Stingray\",    “region”  :  “Cairns, Queensland”,    “creator”  :  “Richard Mclean”,    \"identifier\" : \"2007.0053.1115\",    \"physicalDescription\" : \"A painting on canvas featuring a central x-ray stingray with small fish surrounding it. It has green leaf like decoration in the corners. The painting is signed in the bottom right corner ‘Richard McLean’. The canvas is attached to a stretcher fastened with staples on the back.\"},  { \"id\" : \"145875\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting featuring three concentric circles, four boomerangs and animals\",    “region”  :  “Port Hedland, Western Australia”,    “creator”  :  “Unknown”,    \"identifier\" : \"IR 4529.0075\",    \"physicalDescription\" : \"A painting on canvas featuring three concentric circles and four boomerangs in the corners. There are two yellow lizards, three snakes and three kangaroos. On the reverse is an ATSIC sticker which reads ‘PROPERTY OF ATSIC STH HEADLAND REGIONAL OFFICE 00148’. The canvas is stretched to a wooden strainer and has wooden frame.\"},  { \"id\" : \"145704\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting of two butterflies and three flowers\",    “region”  :  “Townsville, Queensland”,    “creator”  :  “Karen Doolan”,    \"identifier\" : \"IR 4528.0207\",    \"physicalDescription\" : \"A painting on brown mount board featuring two butterflies and three flowers. The butterflies have brown bodies with yellow wings with black line and dot detail. They are sitting on a branch with leaves painted brown with white dot outline and black line and dot detail. The flowers are yellow with brown and black dots. The flowers have brown leaves behind them and white lines that coil at the ends with pink dots. The painting is signed in the bottom left corner ‘KAREN DOOLAN 97 ©’. The painting is under glass with light yellow mat and wooden frame.\"},  { \"id\" : \"145566\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Bark painting depicting a snake, crab and crocodile\",    “region”  :  “Cairns, Queensland”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.0212\",    \"physicalDescription\" : \"A painting on bark featuring a snake, a crab and a crocodile. The animals are positioned horizontally across the bark. The snake is painted black with yellow, brown and white line patterns and a forked tongue. The crab is yellow with black, white and brown cross hatchings. The crocodile is black with white line markings. The background is brown with varying black, yellow and white flower designs. Wooden sticks are attached to the top and bottom of the bark with string. On the reverse is a silver sticker from the ‘ABORIGINAL DEVELOPMENT COMMISSION’ with the ADC asset number ‘4 0731’.\"},  { \"id\" : \"145515\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Dot painting depicting witchetty grubs\",    “region”  :  “Tennant Creek, Northern Territory”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.1139\",    \"physicalDescription\" : \"A dot painting on canvas featuring a central design of a circle radiating eight groups of witchetty grubs with two large witchetty grubs on the top and bottom. There are four half circles on the corners and the background is filled in with multicoloured dots. On the reverse is a signature ‘[...]VIN DOBBS. 97’ on the back of the canvas. Also on the back on the canvas is text which is difficult to read because is covered by the strainer. There is also a sticker with the number ‘38’. The Canvas is attached to a strainer with staples.\"},  { \"id\" : \"145838\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting of a bird of prey\",    “region”  :  “Darwin, Northern Territory”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.1088\",    \"physicalDescription\" : \"A colour painting on canvas featuring a bird of prey and flames. The bird of prey sits above of a flame dissecting five black bark trees whose branches are intertwined. At the centre red flame splits the middle tree in half. An orange and red line pattern surrounds the flame. The bird is patterned with red, orange, white and black dot markings on its feathers and face. The bird stands against a number of radiating segments made up of white dots outlined in black on an orange background. The canvas is stretch over a wooden strainer and stapled to the back.\"},  { \"id\" : \"145388\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Photographs\" ],    \"title\" : \"Kunmanggur rock painting\",    “region”  :  “Canberra, Australian Capital Territory”,    “creator”  :  “Unknown”,    \"identifier\" : \"IR 4527.0045\",    \"physicalDescription\" : \"A reproduction photograph of a rock painting of ‘KUNMANGGUR’ a Dreamtime spirit depicted as a face-like design surrounded by radial lines. On the reverse is an information sheet with detailed information about the artwork and significance naming by Professor WEH Stamer as the photographer. The reproduction has a silver aluminium frame.\"},  { \"id\" : \"145836\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting featuring three concentric circles with zigzag pattern surrounding them\",    “region”  :  “Darwin, Northern Territory”,    “creator”  :  “Unknown”,    \"identifier\" : \"IR 4529.0036\",    \"physicalDescription\" : \"A dot painting on canvas featuring three concentric circles horizontally across the middle with the central circle highlighted with white in a zigzag pattern. At the top in the middle is a group of bush fruits painted yellow, red and green. On right and left sides are yellow, green, red, orange and purple oddly shaped dotted patches with three groups of symbols painted brown with white dot detail. At the bottom in the middle are a group of shapes resembling witchetty grubs and honey ants. On the reverse is a red stamp at the bottom and underneath it in black ink the date ’23 06 2000.’. The painting has a dark brown wooden frame with a red ATSIC sticker attached to the front lower member with text that reads ‘PAR0207’.\"},  { \"id\" : \"147406\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Acrylic paintings\" ],    \"title\" : \"Painting depicting witchetty grubs\",    “region”  :  “Canberra, Australian Capital Territory”,    “creator”  :  “Lilly K. Napangati”,    \"identifier\" : \"IR 4534.0096\",    \"physicalDescription\" : \"A colour painting on canvas featuring a central concentric circle with witchetty grubs in four patterned segments. The background id black with brown, yellow, orange, white, pink, purple, blue dots. On the reverse is handwritten text and an ATSIC sticker some of which reads ‘Asset No: C6284’. The canvas is stapled to a wooden strainer and has a black wooden frame.\"},  { \"id\" : \"145748\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Silk painting of two lizards\",    “region”  :  “Ceduna, South Australia”,    “creator”  :  “Josie Davey”,    \"identifier\" : \"2007.0053.1564\",    \"physicalDescription\" : \"A colour painting on silk featuring two lizards, two boomerang shaped objects and a snake on an off white background with yellow and brown arc patterns.  The artists signature ‘Josie Davey’ is in the bottom right corner. The painting is under glass and has a yellow matt with a black wooden frame.\"},  { \"id\" : \"146670\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Landscape painting with blue and purple\",    “region”  :  “Melbourne, Victoria”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.1322\",    \"physicalDescription\" : \"A landscape painting on board of a bush scene featuring a white gum tree on the right side and a group of trees on the left. The painting is painted in purple and blue with white trees.\"},  { \"id\" : \"146828\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting of a screaming person\",    “region”  :  “Melbourne, Victoria”,    “creator”  :  “Charles Spence”,    \"identifier\" : \"IR 4532.0346\",    \"physicalDescription\" : \"A colour painting on board featuring a person, who appears to be screaming, holding an object split into two against a red background. In the bottom right corner is the signature ‘C. SPENCE 86’. On the reverse a sheet of brown paper has been attached with red tape. The painting has a decorative gold wooden frame.\"},  { \"id\" : \"145507\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Watercolour paintings\" ],    \"title\" : \"Watercolour painting of wet landscape\",    “region”  :  “Perth, Western Australia”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.1624\",    \"physicalDescription\" : \"A watercolour and ink on paper featuring a bush scene with a grey gum tree and grass tree in the centre. Primarily painted in greens and blues with brown details. There is a signature in the bottom right-hand corner that is indecipherable.\"},  { \"id\" : \"147082\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Acrylic paintings\" ],    \"title\" : \"Dot painting with two white hands\",    “region”  :  “Geraldton, Western Australia”,    “creator”  :  “Velda Lane”,    \"identifier\" : \"IR 4533.0205\",    \"physicalDescription\" : \"A colour dot painting on canvas board featuring two white hand prints with and overlapping concentric circle on a background of brown, yellow, grey and white dots. There is a framer’s stamp on the reverse. The painting is framed in a wooden frame.\"},  { \"id\" : \"147273\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"An underground tuber and its vines\",    “region”  :  “Melbourne, Victoria”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.0946\",    \"physicalDescription\" : \"A bark painting featuring yellow lines surrounded by brown outlined with white and white dots. Above them are brown, wavy lines with yellow dots outlined with white. The background is pigmented brown. On the reverse is handwritten text in black ink that reads ‘AF115’, and a sticker that reads ‘An underground tuber and its vines’. At the top and the bottom of the bark are two sticks on the front and the back of the bark bound together with string through holes in the bark.\"},  { \"id\" : \"146108\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting of an echidna\",    “region”  :  “Cairns, Queensland”,    “creator”  :  “Colin Wightman”,    \"identifier\" : \"2007.0053.1059\",    \"physicalDescription\" : \"A painting on canvas featuring an echidna in a round ball with black line patterns and white dot detail. The background is brown with yellow dribbles of paint. There are concentric circle designs in black paint surrounding the echidna and a small stick figure holding a spear left of centre. There is also a white boarder with lines and dot alternating patterns surrounded by a final black boarder. There is nothing on the reverse. The canvas is on a wooden stretcher and is stapled to the sides and back.\"},  { \"id\" : \"145756\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Solitary Tree\",    “creator”  :  “Gordon Syron”,    “region”  :  “Sydney, New South Wales”,    \"identifier\" : \"IR 4528.0259\",    \"physicalDescription\" : \"A painting on canvas featuring a solitary tree in a field with a barbed wire fence running along the bottom and at the top of the hill. There is a blue sky with white clouds. The painting is signed in the bottom right corner ‘SYRON’. On the reverse is handwritten text some of which reads ‘DAA 23 SOLITARY TREE 6 S.O. (A) 23’ There is a piece of paper stuck to the back with text that begins with ‘GORDON SYRON is Birpai tribe....’. The canvas is stapled to a strainer.\"},  { \"id\" : \"146844\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Colour painting depicting four aboriginal men by H. Williams\",    “region”  :  “Canberra, Australian Capital Territory”,    “creator”  :  “Unknown”,    \"identifier\" : \"IR 4532.0362\",    \"physicalDescription\" : \"A colour painting on black velvet featuring four aboriginal men wearing, one playing the didjeridu and three dancing. In the bottom right corner is a signature ‘H . Williams 89.’. On the reverse handwritten twice in black ink is ‘ATSIC’ and a bar code sticker with the number ‘A00165’. The painting has a decorative gold wooden frame.\"},  { \"id\" : \"147002\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Bark painting of snakes and turtles\",    “region”  :  “Ceduna, South Australia”,    “creator”  :  “Jimmy Moduk”,    \"identifier\" : \"2007.0053.0896\",    \"physicalDescription\" : \"A colour bark painting depicting a group of long-necked turtles, catfish and snakes. The bark is pigmented brown with brown, yellow and white cross hatching on all the animals. There are black, yellow and white line patterns on the background. On the reverse is a piece of paper with typed and handwritten text that reads ‘Artist: Muduk ...’. There are also two stickers one reads ‘ATSIC A0000153’ and ‘PROPERTY OF ATSIC CRO 00152’.\"},  { \"id\" : \"146163\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Dot Painting featuring rings of black, white and brown dot lines\",    “region”  :  “Perth, Western Australia”,    “creator”  :  “Unknown”,    \"identifier\" : \"IR 4530.0129\",    \"physicalDescription\" : \"A circular dot painting on board featuring rings of white, black and brown dot lines surrounding three horseshoe shapes at the centre. On the reverse is a silver sticker with the text ‘Aboriginal Development Commission Asset No:6 1144’ and handwritten in black ink the number ‘741-6-18’. The board is mounted on a backing board with white covering fabric and has a brown wooden frame.\"},  { \"id\" : \"146698\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Landscape painting\",    “region”  :  “Port Augusta, South Australia”,    “creator”  :  “I. A. Brown”,    \"identifier\" : \"2007.0053.1156\",    \"physicalDescription\" : \"A colour landscape painting on canvas board featuring a tree with a brown bark and double trunks. The tree is in the foreground of an orange terrain with rocky outcrops to the left and right. A yellow and blue sky is depicted in the background. A signature ‘I.A.BROWN’ is in the bottom right corner. On the reverse is text in blue ink ‘4-015-1088-12’.\"},  { \"id\" : \"145671\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Landscape painting with black ink\",    “region”  :  “Perth, Western Australia”,    “creator”  :  “Robert Eggington”,    \"identifier\" : \"2007.0053.1286\",    \"physicalDescription\" : \"An black ink painting on paper of a landscape. There are two leafless trees one on the left and one on the right with their shadow falling to the left. In the background are smaller leafless trees with a dark patch of trees and shrubs across the middle with the bottom edges bleeding. There are eleven small birds in the sky and the foreground is filed with a wash technique.\"},  { \"id\" : \"146758\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Acrylic paintings\" ],    \"title\" : \"Painting of five bugs with red back\",    “region”  :  “Melbourne, Victoria”,    “creator”  :  “Heather J. Walker”,    \"identifier\" : \"IR 4532.0276\",    \"physicalDescription\" : \"A dot painting on canvas board featuring five beetles with red backs on blades of green grass. The back is brown with black, white, blue and yellow dots. On the reverse is and ATSIC sticker that reads 'Asset No: VT 0060'. The painting is under glass has a wooden inner frame with green mat and wooden outer frame.\"},  { \"id\" : \"146615\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Kingfisher and Mangrove Tree\",    “region”  :  “Sydney, New South Wales”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.1063\",    \"physicalDescription\" : \"A bark painting featuring worm-like shapes in red and brown with yellow, red and white cross-hatching between them. One end of the painting has a white cross hatched triangle with a black back ground and the oppisite end of the paing shows two yellow triangles with a black one between them on a white back ground. The bark has been braced at one end with two sticks of wood fastened with bark fibre string.\"},  { \"id\" : \"147244\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Bark painting of three brolgas and an egg\",    “region”  :  “Sydney, New South Wales”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.0952\",    \"physicalDescription\" : \"A painting on bark depicting three brolgas and an egg in a nest. The brolgas and egg are painted in yellow, brown and white on a white background. The bark is braced with wood and twine. On the reverse of the bark ‘$30’ and ‘BROLGA + egg’ are handwritten in black pencil.\"},  { \"id\" : \"147357\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Bark painting depicting three crabs and six birds\",    “region”  :  “Canberra, Australian Capital Territory”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.0996\",    \"physicalDescription\" : \"A colour painting on bark featuring three crabs in circles and six birds. The circles are aligned horizontally are grey in colour with a red, yellow and black boarder. The birds are positioned vertically in groups of three on either side of the centre circle. The birds are black with red and white markings. The painting is bordered by grey, red and white patterned rings. ’BOB IAN PUPULI’ is written on the back of the bark with black marker.\"},  { \"id\" : \"146137\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Dot Painting featuring four honey ants\",    “region”  :  “Alice Springs, Northern Territory”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.1112\",    \"physicalDescription\" : \"A dot painting on canvas with a central circle design surrounded by four honey ants three painted green and on painted yellow with black stripes and dot detail. There are also four concentric circles in the corners painted in yellow, white and black with a brown background. On the reverse of the painting is hand written text ‘RJ37’ and on the wooden stretcher is a white sticker and hand written text ‘E015’. At the top edge of the canvas is another sticker black with white typed text ‘EO.15’. The painting is attached to a stretcher stapled at the sides.\"},  { \"id\" : \"146330\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bullroarers\" ],    \"title\" : \"'Tourist art' bullroarer decorated with a painting of a goanna\",    “region”  :  “Townsville, Queensland”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.0081\",    \"physicalDescription\" : \"A wooden 'tourist art' bullroarer decorated with a painting of a goanna on one side. It has been coated in a glossy varnish. It has a hole in one end. There is a red sticker on it that reads ‘66’.\"},  { \"id\" : \"146702\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"'Googarh', painting of Albert Namatjira\",    “region”  :  “Brisbane, Queensland”,    “creator”  :  “Roy Carrigy”,    \"identifier\" : \"IR 4532.0220\",    \"physicalDescription\" : \"A colour painting on canvas board featuring a grey bearded man. The man is looking to the right and wearing a green shirt with brown buttons. Behind the man is a red soil landscape, purple hills and a blue sky. A signature 'ROY CARRIGY' is in the bottom right corner. On the reverse is stuck a white bar code 'F0008583' and a white piece of paper with black text 'ALBERT NAMATJIRA...'. The painting has a brown, white and black frame with gold edging.\"},  { \"id\" : \"147128\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Painting of a lizard and gum trees\",    “region”  :  “Darwin, Northern Territory”,    “creator”  :  “Gonzales Mungatopi”,    \"identifier\" : \"IR 4533.0251\",    \"physicalDescription\" : \"A colour painting on canvas featuring a cross like design decorated with a central concentric circle and dot patterns on a background of yellow, red and blue lines. On the reverse is a stamp and handwritten text that reads ‘CAT No A3081 PAR0183 MR Gonzales Mungatopi ….’. The painting has a gold wooden mount under the glass and a black wooden frame.\"},  { \"id\" : \"145830\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Bark paintings\" ],    \"title\" : \"Bark painting depicting a brolga and fish\",    “region”  :  “Wagga Wagga, New South Wales”,    “creator”  :  “Unknown”,    \"identifier\" : \"2007.0053.1006\",    \"physicalDescription\" : \"A colour painting on bark featuring an brolga and a fish. The brolga is to the left side of the painting and the fish is positioned in the upper right corner. Both have a white, brown and yellow cross hatch design. Two pieces of wood are tied to the top and bottom of the bark with string.\"},  { \"id\" : \"145877\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Painting featuring a kangaroo and four figures\",    “region”  :  “Queanbeyan, New South Wales”,    “creator”  :  “D. Smith”,    \"identifier\" : \"IR 4529.0077\",    \"physicalDescription\" : \"A painting on board featuring a kangaroo in the centre surrounded by four figures two with spears and two with boomerangs. In the corners are concentric circles with symbolic designs. The painting is signed in the bottom right ‘D Smith’. On the reverse is two stickers one has handwritten text that reads ‘QICC-7’. The painting has a wooden frame which is loose.\"},  { \"id\" : \"147153\",    \"type\" : \"object\",    \"additionalType\" :     [ \"Paintings\" ],    \"title\" : \"Two Ngalkordow\",    “region”  :  “Darwin, Northern Territory”,    “creator”  :  “Noel Nabegeyol”,    \"identifier\" : \"2007.0053.1368\",    \"physicalDescription\" : \"A colour ochre painting on paper featuring two birds patterned with brown, white and yellow etchings.\"}";
    Gson gson = new Gson();
    Art art = gson.fromJson(artDetailsJson, Art.class);
}