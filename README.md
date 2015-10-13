# GeneBurst

Contributors: James Barbour, [Scott Emmons](http://scottemmons.com/), Luke Tannenbaum

Determining microbial community composition is a fundamental problem in ecology. Researchers spend years planning, funding, and executing expeditions to remote locations of the globe to collect samples for study. After extracting DNA samples in the lab, researchers use open-source software tools, such as [Qiime](http://qiime.org/), to process their DNA sequencing data. While such software efficiently processes the data, researchers are left with the challenge of interpreting it -- rows upon rows of numbers.

GeneBurst, acting as a direct Qiime to [D3.js](http://d3js.org/) converter, meets the cyberinfrastructure needs of biological researchers. It takes the raw CSV data that Qiime outputs and convertes it to a JSON file that can be passed into our D3.js sunburst visualization. A sunburst, which depicts the community composition of an individual location, has a hierarchical structure; as the burst progresses radially outward, it increases in taxonomic resolution. The size of each sunburst arc encodes the given taxonomic unit's percentage by biomass of a community. For our example visualization, we've used data from an Antarctic research project by the Arnosti lab of UNC Marine Sciences.

While GeneBurst is designed to be used with Qiime, it will provide a tree-structured visualization for any dataset in the following format:
```
levelName,set0,set1,set2,set3,setN
level0;level1;level2;levelN,0.1,0.1,0.1,0.1,0.1
level0;level1;level2;levelN,0.1,0.1,0.1,0.1,0.1
level0;level1;level2;levelN,0.1,0.1,0.1,0.1,0.1
level0;level1;level2;levelN,0.1,0.1,0.1,0.1,0.1
```

An example using taxonomic stucture and percentage of occurences of organisms at different sites:
```
taxon,site0,site1,site2,site3,site4
domainName0;kingdomName0;phylumName0;className0;orderName0;familyName0;genusName0;speciesName0,0.2,0.9,0.99,0.2,0.1
domainName1;kingdomName1;phylumName1;className1;orderName1;familyName1;genusName1;speciesName1,0.3,0.1,0.0,0.2,0.3
domainName2;kingdomName2;phylumName2;className2;orderName2;familyName2;genusName2;speciesName2,0.3,0.0,0.0,0.3,0.4
domainName3;kingdomName3;phylumName3;className3;orderName3;familyName3;genusName3;speciesName3,0.2,0.0,0.01,0.3,0.2
```

[geneburst.jebarb.com](http://geneburst.jebarb.com)
