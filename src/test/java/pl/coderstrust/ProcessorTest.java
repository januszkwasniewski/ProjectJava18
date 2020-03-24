package pl.coderstrust;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProcessorTest {

    @Mock
    NumbersProcessor numbersProcessor;

    @Mock
    FileProcessor fileProcessor;

    @InjectMocks
    Processor processor;

    @Test
    public void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() {
        // given

        //        when(numbersProcessor.processLine("1 2 3")).thenReturn("1+2+3=6");


        doReturn("1+2+3=6").when(numbersProcessor).processLine("1 2 3");
        doReturn("4+5+6=15").when(numbersProcessor).processLine("4 5 6");


//        when(fileProcessor.readLinesFromFile("fileName.txt")).thenReturn(Arrays.asList("1 2 3", "4 5 6"));

        // when
        processor.process("fileName.txt", "output.txt");

        // then
//        verify(fileProcessor).readLinesFromFile(...
//        verify(numbersProcessor).processLine(....
//        verify(fileProcessor).writeLinesToFile(....
    }

}